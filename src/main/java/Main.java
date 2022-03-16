import org.kohsuke.github.GHRepository;
import org.kohsuke.github.GitHub;
import org.kohsuke.github.GitHubBuilder;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        GitHub github = null;

        try {
            String Fichero ="/home/dam1/cod/AccesoGitHub/Token.propierties";
            github = new GitHubBuilder()
                    .fromPropertyFile(Fichero)
                    .build();

        } catch (IOException e) {
            e.printStackTrace();
        }
        GHRepository repo = null;
        try {
            repo = github
                    .createRepository("RepositorioSergio")
                    .create();

        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            repo.addCollaborators(github.getUser("abayer"),github.getUser("rtyler"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
