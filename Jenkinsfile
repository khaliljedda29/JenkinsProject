pipeline{

      agent {
                docker {
                image 'maven:3-openjdk-11'

                }
            }
        
        stages{
              stage('Test') {
                          steps {
                              sh './gradlew check'
                          }
                      }
                  }
                  post {
                      always {
                          junit 'build/reports/**/*.xml'
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

		
            }	       	     	         
}
