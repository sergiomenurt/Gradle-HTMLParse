import org.kohsuke.github.GHRepository;
import org.kohsuke.github.GitHub;
import org.kohsuke.github.GitHubBuilder;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        GitHub github = null;
       /* try {
            github = GitHub.connect();
        } catch (IOException e) {
            e.printStackTrace();
        }*/
        try {
            String pathalFich="/home/dam1/cod/AccesoGitHub/FicheroToken.propierties";
            github = new GitHubBuilder()
                    //.withOAuthToken("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")
                    .fromPropertyFile(pathalFich)
                    .build();

        } catch (IOException e) {
            e.printStackTrace();
        }
        GHRepository repo = null;
        try {
            repo = github
                    .createRepository("miRepo")
                    .create();
            //repo = github.createRepository(
                    //"new-carnival","this is my new repository",
                    //"https://www.kohsuke.org/",true/*public*/);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            repo.addCollaborators(github.getUser("abayer"),github.getUser("rtyler"));
        } catch (IOException e) {
            e.printStackTrace();
        }
       /* try {
            repo.delete();
        } catch (IOException e) {
            e.printStackTrace();
        }*/
    }
}
