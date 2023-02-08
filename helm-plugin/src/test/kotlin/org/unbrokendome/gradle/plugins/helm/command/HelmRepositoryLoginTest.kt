package org.unbrokendome.gradle.plugins.helm.command

import org.spekframework.spek2.style.specification.describe
import org.unbrokendome.gradle.plugins.helm.command.tasks.HelmAddRepository
import org.unbrokendome.gradle.plugins.helm.spek.ExecutionResultAwareSpek
import org.unbrokendome.gradle.plugins.helm.spek.gradleExecMock
import org.unbrokendome.gradle.plugins.helm.testutil.exec.singleInvocation
import org.unbrokendome.gradle.pluginutils.test.execute
import org.unbrokendome.gradle.pluginutils.test.spek.applyPlugin
import org.unbrokendome.gradle.pluginutils.test.spek.gradleTask
import org.unbrokendome.gradle.pluginutils.test.spek.setupGradleProject

object HelmRepositoryLoginTest: ExecutionResultAwareSpek({
    val project by setupGradleProject { applyPlugin<HelmCommandsPlugin>() }

    val execMock by gradleExecMock()

    val taskOci by gradleTask<HelmAddRepository> {
        repositoryName.set("my-registry")
        url.set(project.uri("oci://my-repo.example.com"))
    }

    withOptionsTesting(GlobalOptionsTests) {

        describe("executing a HelmAddRepository task") {

            it("should execute helm repo add") {
                taskOci.execute()

                execMock.singleInvocation {
                    expectCommand("registry", "login")
                    expectArg("my-registry")
                    expectArg("my-repo.example.com")
                }
            }
        }
    }
})