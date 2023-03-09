pipeline {
    agent any

    stages {
        stage('Checkout Git Branch ') {
            steps {
                
                echo 'Pulling For Ines Branch... '
                git branch: 'Ines',
                url : 'https://github.com/Bellalouna/AchatProjet.git'
            }
        }
        
        
        stage('mvn clean project'){
            steps {
                sh 'mvn clean'
            }
        }
        
        stage('mvn compile project'){
            steps {
                sh 'mvn compile'
            }
        }
        
         stage('Test quality code with SONARQUBE'){
            steps {
                echo "Welcome to SONARQUBE"
            }
        }

        
        stage('Deploy artifactory to Nexus registry') {
            steps{
                withMaven(maven: 'Maven 3.8.3') {
                   echo 'Welcome Nexus'
                }
            }
        }
        
    }
}