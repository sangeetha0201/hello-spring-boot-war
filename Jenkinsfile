pipeline {
    agent { label 'jenkins-slave1' }
    stages {
        stage('SonarQube analysis') {
            steps {
                withSonarQubeEnv('local-sonar') {
                   bat 'mvn clean org.jacoco:jacoco-maven-plugin:prepare-agent install org.jacoco:jacoco-maven-plugin:report'
                   bat 'mvn sonar:sonar' 
                }
            }
        }
        stage('maven build'){
            steps{
                bat 'mvn -DskipTests clean package'
            }
        }
        }
    }
