pipeline {
   agent { label 'ubuntuslave1' }
    stages {
        stage('maven build...'){
            steps{
                sh 'mvn clean install'
            }
        }
    }
   post {
        always {
         deploy adapters: [tomcat9(credentialsId: 'tomcat-creds', path: '', url: 'http://13.235.103.50:8080/')], contextPath: null, war: '**/*.war'
      }
}
    }
