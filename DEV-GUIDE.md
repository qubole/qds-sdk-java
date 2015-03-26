### RELEASE PROCESS

0. Develop. Develop. Develop.

1. Update the version number in `pom.xml` (example: from `0.5.2-SNAPSHOT` to `0.5.2`).
   Update the version number in `README.md` (example: from `0.5.1` to `0.5.2`.)
   Update the version number in `examples/pom.xml` (example: from `0.5.2-SNAPSHOT` to `0.5.2`.)

2. Commit and push to GitHub.

3. Go to https://github.com/qubole/qds-sdk-java/releases and draft a new release: add a tag (example: `0.5.2`) and what changed since the last release.

4. Make sure you have Qubole's OSSRH credentials stored in `~/.m2/settings.xml`.

    ```
    <server>
        <id>ossrh</id>
        <username>qubole</username>
        <password>ENCRYPTED-PASSWORD</password>
    </server>
    ```

5. Make sure you have `gpg` installed and Qubole's private key in the correct location.

6. Upload to OSSRH (make sure to compile with java 1.6)

    ```
    export JAVA_HOME=`/usr/libexec/java_home -v 1.6`  # or equivalent for your platform.
    mvn -Prelease clean deploy
    ```

7. Check that the release is okay by checking the [staging site](https://oss.sonatype.org/content/groups/staging/com/qubole/qds-sdk-java/qds-sdk-java/) and then promote it to [Central](http://repo.maven.apache.org/maven2/com/qubole/qds-sdk-java/qds-sdk-java/).
    ```
    mvn -Prelease nexus-staging:release
    ```

8. Update the [`apidocs`](https://github.com/qubole/qds-sdk-java/tree/gh-pages/apidocs) directory in the `gh-pages` branch with the latest docs.
    ```
    # Switch back to Java 8
    export JAVA_HOME=`/usr/libexec/java_home -v 1.8`

    # Generate the javadocs while on the master branch
    mvn clean javadoc:javadoc

    # Checkout the gh-pages branch
    git checkout gh-pages

    # Create a new directory for current version
    cd apidocs
    mkdir 0.5.2

    # Move the docs to this directory and point the latest symlink to it
    mv ../target/site/apidocs/* 0.5.2/
    rm latest
    ln -s 0.5.2/ latest

    # Commit and push the changes.
    git add 0.5.2 latest
    git commit -m "Update docs for 0.5.2"
    git push origin gh-pages

    # Checkout the master branch again
    git checkout master
    ```

9. Update the version number in `pom.xml` and `examples/pom.xml` back to SNAPSHOT (example: from `0.5.2` to `0.5.3-SNAPSHOT`). Commit and push to Github.
