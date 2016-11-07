/**
 * Created by sunil on 6/28/16.
 * This class defined the protocol used to communicate between FoilMaker clients and the server.
 *
 */
public class FoilMakerNetworkProtocol {

    public static enum MSG_TYPE {

        //Client messages to server

        CREATENEWUSER("CREATENEWUSER"), // Tokens: userName  passWord
        LOGIN("LOGIN"), // Tokens: userName password
        LOGOUT("LOGOUT"), // Tokens:  currentLoginToken?
        STARTNEWGAME("STARTNEWGAME"), // No tokens?
        JOINGAME("JOINGAME"), // Tokens: currentLoginToken gameKey
        ALLPARTICIPANTSHAVEJOINED("ALLPARTICIPANTSHAVEJOINED"), // Send from leader to server; Tokens: currentLoginToken gameKey

        //Client message to server during a game
        PLAYERCHOICE("PLAYERCHOICE"), // Tokens: currentLoginToken gameKey user'sChoice
        PLAYERSUGGESTION("PLAYERSUGGESTION"), // Tokens: currentLoginToken gameKey user'sChoice

        // Server messages to client
        NEWPARTICIPANT("NEWPARTICIPANT"), //From server to leader; Tokens: participantName cummulativeScore
        RESPONSE("RESPONSE"), // Server response to user request
                    /* Tokens:
                     * clientRequestMsgType -- the MSG_TYPE of the client's request
                     * responseDetail -- the MSG_DETAIL_T of the server's response
                     * <Other optional tokens specific to MSG_DETAIL_T>
                     */


        //Server messages to clients during a game
        NEWGAMEWORD("NEWGAMEWORD"), // From server to players; Tokens: cardFrontText cardBackText
        ROUNDOPTIONS("ROUNDOPTIONS"), // From server to players; Tokens: randomized list of user suggestions and true answer
        ROUNDRESULT("ROUNDRESULT"), //From server to players; Tokens: uName1 score1 message1 uName2 score2 message2 ....
        GAMEOVER("GAMEOVER"); // From server to players: Tokens: MSG_DETAIL

        String command;
        MSG_TYPE(String command) {
            this.command = command;
        }
    };

    public static enum MSG_DETAIL_T {
        SUCCESS("SUCCESS"), // Request was successfull. For LOGIN: currentLoginToken;  For STARTNEWGAME: gameKey; For JOINGAME:
        // gameKey;
        INVALIDUSERNAME("INVALIDUSERNAME"),
        INVALIDUSERPASSWORD("INVALIDUSERPASSWORD"),
        USERALREADYEXISTS("USERALREADYEXISTS"),
        UNKNOWNUSER("UNKNOWNUSER"),
        USERALREADYLOGGEDIN("USERALREADYLOGGEDIN"),
        GAMEKEYNOTFOUND("GAMEKEYNOTFOUND"),
        NO_CONNECTION_TO_SERVER("NO_CONNECTION_TO_SERVER"),
        ERROR_OPENING_NETWORK_CONNECTION("ERROR_OPENING_NETWORK_CONNECTION"),
        USERNOTLOGGEDIN("USERNOTLOGGEDIN"),
        USERNOTGAMELEADER("USERNOTGAMELEADER"),
        INVALIDGAMETOKEN("INVALIDGAMETOKEN"),
        UNEXPECTEDMESSAGETYPE("UNEXPECTEDMESSAGETYPE"),
        INVALIDMESSAGEFORMAT("INVALIDMESSAGEFORMAT"), //TODO received msg with tokens EXPECTING: expected format
        FAILURE("FAILURE"); // optional details of failure cause

        String status;
        MSG_DETAIL_T(String status) {
            this.status = status;
        }

    };

    //TODO Create error codes type and values
    public static final String SEPARATOR = "--";
    public static final int LOGIN_TOKEN_LENGTH = 10;
    public static final int GAME_KEY_LENGTH = 3;
}
