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
                label 'slave-machine-1'
              }
            steps{
                sh 'mvn clean install'
            }
        }
        stage('deploy to tomcatserver1'){   
            agent {
                label 'slave-machine-1'
              }        
            steps{
                deploy adapters: [tomcat9(credentialsId: 'tomcat-server1', path: '', url: 'http://65.2.175.62:8080/')], contextPath: null, war: '**/*.war'
            }
        }
        stage('deploy to tomcatserver2'){   
            agent {
                label 'slave-machine-1'
              }        
            steps{
                deploy adapters: [tomcat9(credentialsId: 'tomcat-server2', path: '', url: 'http://13.127.71.126:8080/')], contextPath: null, war: '**/*.war'
            }
        }
        }
    }
   }
