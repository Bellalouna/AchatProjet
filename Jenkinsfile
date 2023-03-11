pipeline {

	agent any

	stages {
		
		stage('Junit') {
			steps {
				sh 'mvn test'
			      } 
		}
		stage('Build Artifact - Maven') {
			steps {
				sh "mvn clean package -DskipTests=true"
				archive 'target/*.jar'
			      }
		}
		       
		stage('SonarQube + JacOcO Analysis') {
			steps {
				sh "mvn  sonar:sonar -Dsonar.projectKey=projet-ci  -Dsonar.host.url=http://192.168.33.10:9000  -Dsonar.login=faf5060f1fdac026b36edab0e340e8261b1a07cf"

			}
		        post {
				always {

					jacoco execPattern: 'target/jacoco.exec'

				       }    
			    } 

		 }  
		/* stage('Sonatype/Nexus deploy') {
			steps {
				//sh 'mvn clean deploy -DskipTests'
				sh'mvn clean deploy -Dmaven.test.skip=true -Dresume=false'
			      }
		 } */
		 stage('Docker Build and Push') {
                       steps {
                               withDockerRegistry([credentialsId: "docker-hub", url: ""]) {
         			  sh 'printenv'
        			  sh 'docker build -t inesmensi/achatproject .'
	 			  sh 'docker tag inesmensi/achatproject inesmensi/achatproject:latest'
         			  sh 'docker push inesmensi/achatproject:latest'
         			}
     			  }
    		}
		stage('Docker compose') {
      		      steps {
               sh 'docker-compose up '
       				    }
				
		               }
		}
}
