pipeline {
        agent none
        stages {
            stage('SonarQube analysis') {
                agent any
                steps {
                    withSonarQubeEnv('local-sonar1') {
                       bat 'mvn clean org.jacoco:jacoco-maven-plugin:prepare-agent install org.jacoco:jacoco-maven-plugin:report'
                       bat 'mvn sonar:sonar' 
                    }
                }
            }
            stage("Quality Gate") {
                agent any
                steps {
                    sleep(10)
                    timeout(time: 5, unit: 'MINUTES') {
                        // Parameter indicates whether to set pipeline to UNSTABLE if Quality Gate fails
                        // true = set pipeline to UNSTABLE, false = don't
                        waitForQualityGate abortPipeline: true
                    }
                }
            }
            stage('maven build'){
                agent {
                    label 'ubuntu-slave-1'
                  }
                steps{
                    sh 'mvn clean install'
                }
            }
            }
          post {
           agent any
          always {
            junit '**/target/surefire-reports/*.xml'
          }
       } 
        }
