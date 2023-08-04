
def call(body) {
    def pipelineParams = [:]
    body.resolveStrategy = Closure.DELEGATE_FIRST
    body.delegate = pipelineParams
    body()

    pipeline {
        agent {
            label "${pipelineParams.agent}"
        }
        stages {
            stage('Test that Jenkins is working') {
                steps {
                    sh "echo 'The pipeline works!'"
                }
            }
        }
    }
}
