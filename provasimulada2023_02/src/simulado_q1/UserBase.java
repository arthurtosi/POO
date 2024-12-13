package simulado_q1;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class UserBase {
    private Set<User> users = new HashSet<User>();

    public User createUser(String name) {
        User user = new User(name);
        users.add(user);
        return user;
    }

    public VerifiedUser createVerifiedUser(String name, Date verificationDate) {
        VerifiedUser user = new VerifiedUser(name, verificationDate);
        users.add(user);
        return user;
    }

    public double porcentagemVerificados() {
        int verifiedCount = 0;
        for (User user : users) {
            if (user instanceof VerifiedUser) {
                verifiedCount++;
            }
        }
        return users.isEmpty() ? 0.0 : (double) verifiedCount / users.size() * 100;
    }

    public double tamanhoMedioTweets() {
        int totalLength = 0;
        int tweetCount = 0;
        for (User user : users) {
            for (Tweet tweet : user.getTweets()) {
                totalLength += tweet.getLength();
                tweetCount++;
            }
        }
        return tweetCount == 0 ? 0.0 : (double) totalLength / tweetCount;
    }
}
