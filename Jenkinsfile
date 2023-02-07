pipeline {
    agent any
    stages {
        stage('maven build'){
            steps{
                sh 'mvn -DskipTests clean install package' 
            }
        }
        }
    }
