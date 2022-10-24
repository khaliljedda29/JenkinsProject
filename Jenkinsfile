pipeline{
agent any
  tools {
     jdk 'JAVA_HOME'
     maven 'M2_HOME'
  }
  	  environment {
        
        DOCKERHUB_CREDENTIALS = credentials('DockerHubID')
    }
        
        stages{
	
                         
                 stage('Build Maven Spring'){
                             steps{
                                sh 'mvn clean install '
                             }
                         }
                        
			    stage('Build docker image'){
                             steps{
                                 script{
                                    sh 'docker build -t $DOCKERHUB_CREDENTIALS_USR/springprojet .'
                                 }
                             }
                         }
	

                stage('Testing process') {
                              steps {
                               script {
                                sh 'echo "Test is processing ...."'
                                sh 'mvn clean test'
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
			
          stage('docker compose'){
                         steps{
                                script{
                                 sh 'docker-compose up -d'
                                 }
                           }
                       }

      
		 		 stage('Docker login') {
    	
                                         steps {
                                          sh 'echo "login Docker ...."'
                   	sh 'docker login -u $DOCKERHUB_CREDENTIALS_USR -p $DOCKERHUB_CREDENTIALS_PSW'
                               }  }
		 stage('Docker push') {
    	
                 steps {
                      sh 'echo "Docker is pushing ...."'
                     	sh 'docker push $DOCKERHUB_CREDENTIALS_USR/springprojet'
                        }  }

        }

      }
