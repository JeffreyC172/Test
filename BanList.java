package com.apcsa.democracybot;

import java.util.ArrayList;

public class BanList {

    private ArrayList<Word> currentlyBanned = new ArrayList<>();
    private ArrayList<Word> everBanned = new ArrayList<>();
    private ArrayList<Users> currentlyPunished = new ArrayList<>();
    private ArrayList<Users> trackedUsers = new ArrayList<>();

    public BanList() {
    }

    public void punish(String username, String userid){
    boolean isNew = true;
    int location=0;
        for (int i;i<trackedUsers.size();i++) {
            if (trackedUsers.get(i).getId().equals(userid)) {
                isNew = false;
                location=i;
                break;
            }
        }
        punishing(isNew, username, userid, location);
    }

    public int punishing(boolean newStatus, String username, String userid,int location){
    if (newStatus) {
            Users newUser = new Users(username, userid);
            currentlyPunished.add(newUser);
            trackedUsers.add(newUser);
            return newUser.getNumViolations();
        }
    else {
    currentlyPunished.add(trackedUsers.get(location));
    trackedUsers.get(location).repeatOffense();
    return trackedUsers.get(location).getNumViolations();
    }
    }

    public void banning(String incomingWord) {
        boolean isNew = true;
        for (Word i : everBanned) {
            if (i.getWord().equals(incomingWord)) {
                isNew = false;
                break;
            }
        }
        addList(isNew, incomingWord);
    }

    public void addList(boolean isNew, String reBan) {
        if (isNew) {
            Word newWord = new Word(reBan);
            everBanned.add(newWord);
            if (currentlyBanned.size() > 9) {
                currentlyBanned.getFirst().earlyRemove();
                currentlyBanned.removeFirst();
                currentlyBanned.add(newWord);
            } else {
                currentlyBanned.add(newWord);
            }
        } else {
            boolean found = false;
            for (int i = 0; i < currentlyBanned.size(); i++) {
                if (reBan.equals(currentlyBanned.get(i).getWord())) {
                    Word temp = currentlyBanned.get(i);
                    currentlyBanned.get(i).earlyRemove();
                    currentlyBanned.remove(i);
                    currentlyBanned.add(temp);
                    currentlyBanned.getLast().ban();
                    found = true;
                    i = currentlyBanned.size();
                }
            }
            if (!(found)) {
                for (Word i : everBanned) {
                    if (i.getWord().equals(reBan)) {
                        if (currentlyBanned.size() > 9) {
                            currentlyBanned.getFirst().earlyRemove();
                            currentlyBanned.removeFirst();
                            currentlyBanned.add(i);
                            i.ban();
                        } else {
                            currentlyBanned.add(i);
                            i.ban();
                        }
                    }

                }
            }
        }
    }

    public void passPeriod() {
        for (int i = 0; i < currentlyBanned.size(); i++) {
            currentlyBanned.get(i).dayPass();
            if (currentlyBanned.get(i).doRemove()) {
                currentlyBanned.get(i).earlyRemove();
                currentlyBanned.remove(i);
                i--;
            }
        }
        for (int i=0;i<currentlyPunished.size();i++)
        {
         currentlyPunished.get(i).hourPass();
          if (currentlyPunished.get(i).doUnmute()) {
                currentlyBanned.get(i).earlyRemove(); //fix
                currentlyBanned.remove(i); //fix 
                i--;
            }
        }
    }

    public String current() {
        StringBuilder ret = new StringBuilder();
        for (int i = 0; i < currentlyBanned.size(); i++) {
            ret.append(currentlyBanned.get(i).wordData());
            if (i < currentlyBanned.size() - 1) ret.append(" ");
        }
        return ret.toString();
    }

    public int currentLength() {
        return currentlyBanned.size();
    }

    public String wordAt(int i) {
        return currentlyBanned.get(i).getWord();
    }

    public String ever() {
        StringBuilder ret = new StringBuilder();
        for (int i = 0; i < everBanned.size(); i++) {
            ret.append(everBanned.get(i).wordData());
            if (i < everBanned.size() - 1) ret.append(" ");
        }
        return ret.toString();
    }

    public String toString() {
        StringBuilder ret = new StringBuilder("\n" + "Currently Banned");
        ret.append("\n");
        for (int i = 0; i < currentlyBanned.size(); i++) {
            ret.append(currentlyBanned.get(i));
            if (i < currentlyBanned.size() - 1) ret.append(" ");
        }
        ret.append("\n \n Ever Banned \n");
        for (int i = 0; i < everBanned.size(); i++) {
            ret.append(everBanned.get(i));
            if (i < everBanned.size() - 1) ret.append(" ");
        }
        return ret.toString();
    }


}
