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
        
        stage('mvn package project'){
            steps {
                sh 'mvn package'
            }
        }
        
         stage('Test quality code with SONARQUBE'){
            steps {
                echo "Welcome to SONARQUBE"
            }
        }

        
        stage('Deploy artifactory to Nexus registry') {
            steps{
                withMaven(maven: 'Maven 3.0.5') {
                   echo 'Welcome Nexus'
                }
            }
        }
        
    }
}