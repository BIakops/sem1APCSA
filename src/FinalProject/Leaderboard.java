/**
 * semesterFinalProject
 */
package FinalProject;

import java.util.ArrayList;

public class Leaderboard {

  private ArrayList<String> LeaderBoard = new ArrayList<String>();
  private ArrayList<Teams> Lteams = new ArrayList<>();
  private ArrayList<Players> LPlayers = new ArrayList<>();

  /// DELETE BELOW SOON ONCE IMPLEMENTED NEW FIX
  private ArrayList<Double> LeaderBoardScore = new ArrayList<Double>();
  private ArrayList<Double> LeaderBoardKD = new ArrayList<Double>();
  /// Realized that needed to include more information.
  private ArrayList<Integer> LeaderBoardId = new ArrayList<Integer>();
  private ArrayList<String> LeaderBoardName = new ArrayList<String>();
  /// DELETE EVERYTHING ABOVE

  ///
  /// private ArrayList<teams> LTeams = new ArrayList<teams>();
  // Compiling all cuz I cant do Arrays like in JS that are mutable and accept
  // multiple types
  // Low Key Annoyed!
  private static String[] acceptedTypes = { "Tournament", "Players", "Teams" };

  private String type = "";
  private static int leaderboardsInUse = 0;
  private boolean isOrganized = false;
  private boolean readyToPrint = false;
  private boolean isInstatiated = false;

  public Leaderboard(String t) {
    for (int i = 0; i < acceptedTypes.length; i++) {
      if (t.equals(acceptedTypes[i])) {
        type = t;
      }
    }
    if (type.equals(""))
      throw new IllegalArgumentException(
          "Type Not Accepted");
    isInstatiated = true;
    leaderboardsInUse++;
  }

  public Leaderboard(String t, Players[] p) {
    for (int i = 0; i < acceptedTypes.length; i++) {
      if (t.equals(acceptedTypes[i])) {
        type = t;
      }
    }
    if (t.equals(""))
      throw new IllegalArgumentException(
          "Type Not Accepted");
    isInstatiated = true;
    leaderboardsInUse++;
    type = t;
  }

  // public leaderboard(String t, String[] n) {
  // for (int i = 0; i < acceptedTypes.length; i++) {
  // if (t.equals(acceptedTypes[i])) {
  // type = t;
  // }
  // }
  // if (type.equals(""))
  // throw new IllegalArgumentException("Type Not Accepted");

  // for (int i = 0; i < n.length; i++) {
  // LeaderBoardName.add(n[i]);
  // }
  // leaderboardsInUse++;
  // }

  public static int lIU() { /// FINISHED
    return leaderboardsInUse;
  }

  public String leaderboardType() { /// FINISHED
    return type;
  }

  public boolean isOrganized() { /// FINISHED
    return isOrganized;
  }

  public static String acceptTypes() {
    return ("Accepted Types are: " +
        acceptedTypes[0] +
        ", " +
        acceptedTypes[1] +
        ", " +
        acceptedTypes[2]);
  }

  /// CHANGE LEADERBOARD TO LPLAYERS
  public String printCombatScore() {
    if (!type.equals(acceptedTypes[1]) && isOrganized)
      throw new IllegalArgumentException(
          "Not Compatible with your leaderboard type or not organized");
    String a = ""; /// Should Rewrite
    for (int i = 0; i < LeaderBoardScore.size(); i++) {
      a += LeaderBoardName.get(i) +
          ", has combat score: " +
          LeaderBoardScore.get(i) +
          "\n";
    }

    return a;
  }

  /// REWRITE
  public String printKD() { /// FINISHED (DEC 2)
    /// REWRITE CODE PLS DEC 3
    if (type.equals(acceptedTypes[0]) && isOrganized)
      throw new IllegalArgumentException(
          "Not Compatible with your leaderboard type or not organized");
    String a = "";
    for (int i = 0; i < LeaderBoardScore.size(); i++) {
      a += LeaderBoardName.get(i) + ", has KDA: " + LeaderBoardKD.get(i) + "\n";
    }

    return a;
  }

  /// REWRITE
  public String getPlace(int place, int typeRetrieve) { /// FINISHED Dec 2
    /// DEC 3 REWRITE THIS SHIT
    String s = "";
    /// TEST TABLE EXAMPLE
    if (!(place < 1)) {
      switch (typeRetrieve) {
        case 0:
          s += LeaderBoardScore.get(place - 1);
          break;
        case 1:
          s += LeaderBoardName.get(place - 1).substring(2);
          break;
        case 2:
          break;
        default:
          s += LeaderBoardScore.get(place - 1);
          break;
      }
    }
    return s;
  }

  //// REWRITE DELETE?
  public String compileLeaderBoard() {
    String a = "";
    if (isOrganized) {
      switch (type) {
        case "Player":
          for (int i = 0; i < LeaderBoardId.size(); i++) {
            a += "#" + (i + 1) + " place:" + LPlayers.get(i).toString() + "\n";

            LeaderBoard.add(i, a);
            readyToPrint = true;
          }
      }
      return a;
    } else {
      throw new IllegalArgumentException(
          "Please Organize the leaderboard first.");
    }
  }

  /// 9/10 Done

  /// TO COMPLETE AGAIN CUZ REWRITING CODE!
  public String getLI(int Id, int typeRetrieve) {
    String s = "";
    boolean isValidId = false;
    for (Integer id : LeaderBoardId) {
      if (LeaderBoardId.get(id) == Id) {
        isValidId = true;
      }
    }
    /// TEST TABLE EXAMPLE
    if (isValidId) {
      switch (typeRetrieve) {
        case 0:
          s += LeaderBoardScore.get(Id);
          break;
        case 1:
          for (int i = 0; i < LeaderBoardName.size(); i++) {
            if (LeaderBoardName.get(i).substring(0, 2).equals(String.valueOf(Id))) {
              s += LeaderBoardName.get(i).substring(2);
            }
          }
          break;
        case 2:
          break;
        default:
          /// To Fill
          break;
      }
    }
    return s;
  }

  /*
  
   *
   */
  public String printLeaderBoard() { /// Finished
    /// GOTTA REWRITE Dec 3
    String r = "";

    if (readyToPrint && isInstatiated) {
      switch (type) {
        /// <Summary>
        /// Code based on types run code to print the entire thing.
        /// </Summary>
        case "Players":
          for (int i = 0; i < LPlayers.size(); i++) {
            r += LPlayers.get(i).toString() + "\n";
          }
          break;
        case "Teams":
          for (int i = 0; i < Lteams.size(); i++) {
            r += Lteams.get(i).toString() + "\n";
          }
          break;
        case "Tournament":
          /// Tournament is compared by:
          /// major Y/N
          /// prize pool
          /// Competition Tier
          break;
        default:
      }
    } else {
      throw new IllegalArgumentException("Compile and organize please");
    }
    return r;
  }

  public ArrayList<Players> printf() {
    return LPlayers;
  }

  public void addPlayers(Players[] p) {
    if (isInstatiated && type.equals("Players")) {
      /// Dec 4 Main Problem
      /// FIXED 12/04/21 4:49PM
      for (int i = 0; i < p.length; i++) {
        LPlayers.add(p[i]);
      }
    } else {
      throw new IllegalArgumentException(
          "Board not created or Invalid Method for Type");
    }
  }

  public void addTeams(Teams[] p) {
    if (isInstatiated && type.equals("Teams")) {
      /// Dec 4 Main Problem
      /// FIXED 12/04/21 4:49PM
      for (int i = 0; i < p.length; i++) {
        Lteams.add(p[i]);
      }
    } else {
      throw new IllegalArgumentException(
          "Board not created or Invalid Method for Type");
    }
  }

  /// PLAYER LEADERBOARD
  public void arrL() {
    if (isInstatiated && type.equals("Players")) {
      /// PLayer Case:
      while (!readyToPrint) {
        readyToPrint = true;
        switch (type) {
          case "Players":
            /// Bubble Sort Method
            for (int i = 0; i < LPlayers.size() - 1; i++) {
              if (LPlayers.get(i).cs() < LPlayers.get(i + 1).cs()) {
                Players temp = LPlayers.get(i);
                LPlayers.set(i, LPlayers.get(i + 1));
                LPlayers.set(i + 1, temp);
                readyToPrint = false;
              } else if (LPlayers.get(i).cs() == LPlayers.get(i + 1).cs()) {
                if (LPlayers.get(i).kda() < LPlayers.get(i + 1).kda()) {
                  Players temp = LPlayers.get(i);
                  LPlayers.set(i, LPlayers.get(i + 1));
                  LPlayers.set(i + 1, temp);
                  readyToPrint = false;
                }
              }
            }
          case "Teams":
            /// Bubble Sort
            for (int i = 0; i < Lteams.size() - 1; i++) {
              if (Lteams.get(i).winLoss() < Lteams.get(i + 1).winLoss()) {
                Teams temp = Lteams.get(i);
                Lteams.set(i, Lteams.get(i + 1));
                Lteams.set(i + 1, temp);
                readyToPrint = false;
              } else if (Lteams.get(i).winLoss() == Lteams.get(i + 1).winLoss()) {
                if (Lteams.get(i).wins < Lteams.get(i + 1).wins) {
                  Teams temp = Lteams.get(i);
                  Lteams.set(i, Lteams.get(i + 1));
                  Lteams.set(i + 1, temp);
                  readyToPrint = false;
                }
              }
            }
        }
      }
    } else {
      throw new IllegalArgumentException(
          "Board not created or Invalid Method for Type");
    }
  }

  /// REALIZED CAN PUT INTO PLAYER CLASS, THEN COMPARE THE KDA Then the COMBAT
  /// SCORE TO ORGANIZE, I AM DUMB!
  public void ArrangeByWins() /// For teams in tournament
  {
  }
}
