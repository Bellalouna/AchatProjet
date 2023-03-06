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
                withCredentials([usernamePassword(credentialsId: 'nexus-credentials', usernameVariable: 'NEXUS_USER', passwordVariable: 'NEXUS_PASS')]) {
                    sh 'mvn deploy -Dmaven.deploy.skip=true -DaltDeploymentRepository=nexus::default::http://192.168.1.30:8081/repository/maven-central/deploymentRepo -DrepositoryId=nexus -Dusername=${NEXUS_USER} -Dpassword=${NEXUS_PASS}'
                }
            }
        }
        
    }
}
