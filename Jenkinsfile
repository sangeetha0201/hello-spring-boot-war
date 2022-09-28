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
                timeout(time: 1, unit: 'MINUTES') {
                    // Parameter indicates whether to set pipeline to UNSTABLE if Quality Gate fails
                    // true = set pipeline to UNSTABLE, false = don't
                    waitForQualityGate abortPipeline: true
                }
            }
        }
        stage('maven build'){
            steps{
                bat 'mvn clean install'
            }
        }
        stage('deploy to tomcatserver1'){       
            steps{
                bat deploy adapters {[tomcat9(credentialsId: 'tomcat-server1', path: '', url: 'http://15.206.172.97:8080/')], contextPath: null, war: '**/*.war'}
            }
        }
        stage('deploy to tomcatserver2'){       
            steps{
                bat deploy adapters {[tomcat9(credentialsId: 'tomcat-server2', path: '', url: 'http://3.110.173.41:8080/')], contextPath: null, war: '**/*.war'}
            }
        }
        }
    }
