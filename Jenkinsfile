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

          // stage('mvn install project'){
            //                steps {
              //                  sh 'mvn install'
                //            }
                  //      }
        
        stage('mvn compile project'){
            steps {
                sh 'mvn compile'
            }
        }

               stage('mvn Test project'){
                                    steps {
                                        sh 'mvn test'
                                    }
                                }

          stage('mvn package project'){
                     steps {
                         sh 'mvn package'
                     }
                 }

         stage('Test quality code with SONARQUBE'){
            steps {
                sh 'mvn sonar:sonar -Dsonar.host.url=http://192.168.56.222:32768 -Dsonar.login=admin -Dsonar.password=ines'
            }
        }

        
        stage('Deploy artifactory to Nexus registry') {
            steps{
                withMaven(maven: 'Maven 3.0.5') {
                   sh 'mvn deploy -DskipStaging=true -Dmaven.deploy.skip=false -Dmaven.test.skip=true'
                }
            }
        }
        
    }
}