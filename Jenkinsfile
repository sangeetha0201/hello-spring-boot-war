pipeline {
    agent { label 'slave-1' }
    stages {
        stage('maven build'){
            steps{
                sh 'mvn clean install'
            }
        }
        stage('upload war to s3'){         
            steps{
                s3Upload consoleLogLevel: 'INFO', dontSetBuildResultOnFailure: false, dontWaitForConcurrentBuildCompletion: false, entries: [[bucket: 'sangeetha-jenkins-war', excludedFile: '', flatten: false, gzipFiles: false, keepForever: false, managedArtifacts: false, noUploadOnFailure: false, selectedRegion: 'ap-south-1', showDirectlyInBrowser: false, sourceFile: '**/*.war', storageClass: 'STANDARD', uploadFromSlave: false, useServerSideEncryption: false]], pluginFailureResultConstraint: 'FAILURE', profileName: 's3-uploads', userMetadata: []
            }
        }
        stage('deploy to tomcatserver1'){     
            steps{
                deploy adapters: [tomcat9(credentialsId: 'tomcat-server1', path: '', url: 'http://43.205.229.143:8080/')], contextPath: null, war: '**/*.war'
            }
        }
        }
    }
