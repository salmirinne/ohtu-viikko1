package ohtu;

public class TennisGame {

    private static final String[] POINTS_STRING = {"Love", "Fifteen", "Thirty", "Forty"};
    private static final String[] TIED_POINTS_STRING = {"Love-All", "Fifteen-All", "Thirty-All", "Forty-All", "Deuce"};
    
    private String player1Name;
    private String player2Name;
    private int player1Score;
    private int player2Score;

    public TennisGame(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void wonPoint(String playerName) {
        if (player1Name.equals(playerName)) {
            player1Score++;
        } else if (player2Name.equals(playerName)) {
            player2Score++;
        }
    }

    private String pointsToString(int score) {
        if (score < 0 || score >= POINTS_STRING.length) {
            throw new IllegalArgumentException("Score must be: 0 <= score <= 3");
        }
        return POINTS_STRING[score];
    }

    private String tiedPointsToString(int score) {
        if (score < 0 || score >= TIED_POINTS_STRING.length) {
            throw new IllegalArgumentException("Score must be: 0 <= score <= 4");
        }
        return TIED_POINTS_STRING[score];
    }

    private String gameStateToString(int difference) {
        if (difference == 1) return "Advantage player1";
        else if (difference == -1) return "Advantage player2";
        else if (difference > 1) return "Win for player1";
        return "Win for player2";
    }
    
    private String unequalScoreToString() {
        return new StringBuilder(pointsToString(player1Score)).append("-").append(pointsToString(player2Score)).toString();
    }

    public String getScore() {
        if (player1Score == player2Score) {
            return tiedPointsToString(player1Score);
        } else if (player1Score >= 4 || player2Score >= 4) {
            return gameStateToString(player1Score - player2Score);
        } else {
            return unequalScoreToString();
        }
    }
    
}