pipeline {
    agent { label 'slave1' }
    stages {
        stage('maven build'){
            steps{
                sh 'mvn -DskipTests install package'
            }
        }
        stage('deploy to tomcatserver1'){     
            steps{
                deploy adapters: [tomcat9(credentialsId: 'tomcat-server1', path: '', url: 'http://3.111.149.83:8080/')], contextPath: null, war: '**/*.war'
            }
        }
        }
    }
