pipeline {
    agent { label 'slave1' }
    stages {
        stage('maven build'){
            steps{
                sh 'mvn -DskipTests install package'
            }
        }
        }
    }
