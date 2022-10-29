pipeline {
    agent { label 'slave-1' }
    stages {
        stage('maven build'){
            steps{
                sh 'mvn clean install'
            }
        }
        stage('deploy to tomcatserver1'){     
            steps{
                deploy adapters: [tomcat9(credentialsId: 'tomcat-server1', path: '', url: 'http://43.205.229.143:8080/')], contextPath: null, war: '**/*.war'
            }
        }
        }
    }
