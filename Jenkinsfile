pipeline {
    agent { label 'slave-1' }
    stages {
        stage('maven build'){
            steps{
                sh 'mvn -DskipTests clean package'
            }
        }
        stage('deploy to tomcatserver1'){     
            steps{
                deploy adapters: [tomcat9(credentialsId: 'tomcat-server', path: '', url: 'http://13.233.127.129/')], contextPath: null, war: '**/*.war'
            }
        }
        }
    }
