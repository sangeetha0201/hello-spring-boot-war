pipeline {
    agent any
    stages {
        
        stage('maven build'){
            steps{
                bat 'mvn clean install'
            }
        }
        }
        post {
        always {
         deploy adapters: [tomcat9(credentialsId: 'tomcat-creds', path: '', url: 'http://52.66.157.21:8080/')], contextPath: null, war: '**/*.war'
      }
   }
     }
