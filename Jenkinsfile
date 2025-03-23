pipeline {
    agent any

    tools {
        maven 'Maven_3.8.6'  // Ensure this name matches the one in Jenkins' Global Tool Configuration
        jdk 'Java_11'  // Ensure Java 11 is installed automatically in Jenkins
    }

    stages {
        stage('Clone Repository') {
            steps {
                git branch: 'main', credentialsId: 'github-token', url: 'https://github.com/sarthakjadhav479/Testng-Automation-Framework.git'
            }
        }

        stage('Build') {
            steps {
                sh 'mvn clean install'
            }
        }

        stage('Run Tests') {
            steps {
                sh 'mvn test'
            }
        }

        stage('Publish Test Results') {
            steps {
                junit '**/target/surefire-reports/*.xml'  // TestNG test result publishing
            }
        }
    }

    post {
        always {
            echo 'Pipeline Execution Completed!'
        }
        success {
            echo 'Build and Tests Passed Successfully!'
        }
        failure {
            echo 'Build or Tests Failed! Check the logs.'
        }
    }
}
