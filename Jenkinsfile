pipeline{

      agent {
                docker {
                image 'maven:3-openjdk-11'

                }
            }
        
        stages{

                            stage('Junit Testing') {
                              steps {
                                 sh 'echo "Junit Test is processing ...."'
                                 sh 'mvn test'
                              }
                               post{
                                 always{
                                   sh 'make check || true'
                                   junit '**/target/*.xml'
                                 }
                               }
                            }

              stage('Quality Gate Status Check'){
                  steps{
                      script{
			      withSonarQubeEnv('sonar') { 
			      sh "mvn compile sonar:sonar"
                       	     	}
			      timeout(time: 1, unit: 'HOURS') {
			      def qg = waitForQualityGate()
				      if (qg.status != 'OK') {
					   error "Pipeline aborted due to quality gate failure: ${qg.status}"
				      }
                    		}
		    	    sh "mvn clean install"
		  
                 	}
               	 }  
              }
		stage("Maven Build") {
            steps {
                script {
                    sh "mvn package -DskipTests=true"
                }
            }
        }
stage("Publish to Nexus Repository Manager") {
            steps {
                script {
                    pom = readMavenPom file: "pom.xml";
                    filesByGlob = findFiles(glob: "target/*.${pom.packaging}");
                    echo "${filesByGlob[0].name} ${filesByGlob[0].path} ${filesByGlob[0].directory} ${filesByGlob[0].length} ${filesByGlob[0].lastModified}"
                    artifactPath = filesByGlob[0].path;
                    artifactExists = fileExists artifactPath;
                    if(artifactExists) {
                        echo "*** File: ${artifactPath}, group: ${pom.groupId}, packaging: ${pom.packaging}, version ${pom.version}";
                        nexusArtifactUploader(
                            nexusVersion: 'nexus3',
                            protocol: 'http',
                            nexusUrl: '192.168.1.20:8081',
                            groupId: 'pom.com.esprit.examen',
                            version: 'pom.1.0',
                            repository: 'maven-releases',
                            credentialsId: '2fd3467b-89cc-4b7a-ace8-756b02941c0f',
                            artifacts: [
                                [artifactId: 'pom.tpAchatProject',
                                classifier: '',
                                file: artifactPath,
                                type: pom.packaging],
                                [artifactId: 'pom.tpAchatProject',
                                classifier: '',
                                file: "pom.xml",
                                type: "pom"]
                            ]
                        );
                    } else {
                        error "*** File: ${artifactPath}, could not be found";
                    }
                }
            }
        }

		
        }
      }

