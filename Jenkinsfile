pipeline {
    agent any

    stages {
        stage('Checkout Git') {
            steps {
                
                echo 'Pulling ... '
                git branch: 'Bellalouna',
                url : 'https://github.com/Bellalouna/AchatProjet.git'
            }
        }
        
        
        stage('MVN CLEAN'){
            steps {
                sh 'mvn clean'
            }
        }
        
        stage('MVN COMPILE'){
            steps {
                sh 'mvn compile'
            }
        }
        
         stage('MVN SONARQUBE'){
            steps {
                sh 'mvn sonar:sonar -Dsonar.host.url=http://192.168.1.30:9000 -Dsonar.login=admin -Dsonar.password=123456789' 
            }
        }
        
         stage('Deploy to Nexus') {
            steps {
                sh 'mvn deploy'
            }
        }
        
    }
}
