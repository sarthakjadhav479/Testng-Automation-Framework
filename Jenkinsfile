pipeline {
    agent any

    tools {
        maven 'Maven_3.8.6'  // Ensure this name matches the one in Jenkins' Global Tool Configuration
        jdk 'Java_11'  // Ensure Java 11 is installed automatically in Jenkins
    }

    environment {
        DISPLAY = ':99'  // Set the display for headless execution
    }

    stages {
        stage('Setup Environment') {
            steps {
                script {
                    sh '''
                    echo "Checking Chrome and ChromeDriver versions..."
                    google-chrome --version || echo "Google Chrome is not installed!"
                    chromedriver --version || echo "ChromeDriver is not installed!"

                    echo "Updating system and installing dependencies..."
                    sudo apt-get update
                    sudo apt-get install -y xvfb google-chrome-stable chromium-chromedriver

                    echo "Starting Xvfb..."
                    Xvfb :99 -screen 0 1920x1080x24 &
                    '''
                }
            }
        }

        stage('Clone Repository') {
            steps {
                git branch: 'main', credentialsId: 'github-token', url: 'https://github.com/sarthakjadhav479/Testng-Automation-Framework.git'
            }
        }

        stage('Build') {
            steps {
                sh 'mvn clean install || echo "Build step failed, but continuing..."'
            }
        }

        stage('Run Tests') {
            steps {
                script {
                    sh '''
                    echo "Running tests..."
                    mvn test || echo "Tests failed, but continuing..."
                    '''
                }
            }
        }

        stage('Publish Test Results') {
            steps {
                junit '**/target/surefire-reports/testng-results.xml'
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
