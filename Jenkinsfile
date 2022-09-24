pipeline {
    agent any
    stages {
        stage('SonarQube analysis') {
            steps {
                withSonarQubeEnv('local-sonar1') {
                   bat 'mvn clean org.jacoco:jacoco-maven-plugin:prepare-agent install org.jacoco:jacoco-maven-plugin:report'
                   bat 'mvn sonar:sonar' 
                }
            }
        }
        stage("Quality Gate") {
            steps {
                sleep(60)
                timeout(time: 5, unit: 'MINUTES') {
                    // Parameter indicates whether to set pipeline to UNSTABLE if Quality Gate fails
                    // true = set pipeline to UNSTABLE, false = don't
                    waitForQualityGate abortPipeline: true
                }
            }
        }
        stage('maven build'){
            steps{
                bat 'mvn clean install '
            }
        }
        }
      post {
      always {
        junit '**/target/surefire-reports/*.xml'
      }
   } 
    }pipeline {
    agent any
    stages {
        stage('SonarQube analysis') {
            steps {
                withSonarQubeEnv('local-sonar1') {
                   bat 'mvn clean org.jacoco:jacoco-maven-plugin:prepare-agent install org.jacoco:jacoco-maven-plugin:report'
                   bat 'mvn sonar:sonar' 
                }
            }
        }
        stage("Quality Gate") {
            steps {
                sleep(60)
                timeout(time: 5, unit: 'MINUTES') {
                    // Parameter indicates whether to set pipeline to UNSTABLE if Quality Gate fails
                    // true = set pipeline to UNSTABLE, false = don't
                    waitForQualityGate abortPipeline: true
                }
            }
        }
        stage('maven build'){
            steps{
                bat 'mvn clean install '
            }
        }
        }
      post {
      always {
        junit '**/target/surefire-reports/*.xml'
      }
   } 
    }
