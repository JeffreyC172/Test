import java.util.ArrayList;
public class BanList{

private ArrayList<Word> currentlyBanned=new ArrayList<Word>();
private ArrayList<Word> everBanned=new ArrayList<Word>();   
public BanList(){
}

public void banning(String incomingWord){
boolean isNew=true;
for (int i=0;i<everBanned.size();i++) if (everBanned.get(i).getWord().equals(incomingWord)) isNew=false;
if (isNew){
addList(true, incomingWord);
}
else{
addList(false,incomingWord);
}
}

public void addList(boolean isNew, String reBan)
 {
if (isNew)
  {
    Word newWord =new Word(reBan);
    everBanned.add(newWord);
if (currentlyBanned.size()>9)
   {
currentlyBanned.get(0).earlyRemove();
currentlyBanned.remove(0);
currentlyBanned.add(newWord);
   }
   else
   {
currentlyBanned.add(newWord);
   }
  }

else
 {
  boolean found=false;
  for (int i=0;i<currentlyBanned.size();i++){
  if (reBan.equals(currentlyBanned.get(i).getWord()))
    {
      Word temp=currentlyBanned.get(i);
      currentlyBanned.get(i).earlyRemove();
      currentlyBanned.remove(i);
      currentlyBanned.add(temp);
      currentlyBanned.get(currentlyBanned.size()-1).ban();
      found=true;
      i=currentlyBanned.size();
    }
   }
   if (!(found))  
   {
    for (int i=0;i<everBanned.size();i++){
    if (everBanned.get(i).getWord().equals(reBan)){
       if (currentlyBanned.size()>9)
    {
     currentlyBanned.get(0).earlyRemove();
     currentlyBanned.remove(0);
     currentlyBanned.add(everBanned.get(i));
     everBanned.get(i).ban();
    }
    else
    {
     currentlyBanned.add(everBanned.get(i));
     everBanned.get(i).ban();
    }
    }

   }
   }
  }
 }

public void passPeriod(){
for (int i=0;i<currentlyBanned.size();i++){
    currentlyBanned.get(i).dayPass();
    if (currentlyBanned.get(i).doRemove()){
    currentlyBanned.get(i).earlyRemove();
    currentlyBanned.remove(i);
    i--;
    }
}
}

public String current(){
String ret="";
for (int i=0;i<currentlyBanned.size();i++){
  ret+=currentlyBanned.get(i).wordData();
  if (i<currentlyBanned.size()-1&&currentlyBanned.size()>0) ret+=" ";
}
return ret;
}

public String ever(){
  String ret="";
for (int i=0;i<everBanned.size();i++){
  ret+=everBanned.get(i).wordData();
  if (i<everBanned.size()-1&&everBanned.size()>0) ret+=" ";
}
return ret;
}
public String toString(){
  String ret="\n"+"Currently Banned";
  ret+="\n";
for (int i=0;i<currentlyBanned.size();i++){
  ret+=currentlyBanned.get(i);
  if (i<currentlyBanned.size()-1&&currentlyBanned.size()>0) ret+=" ";
}
ret+="\n \n Ever Banned \n";
for (int i=0;i<everBanned.size();i++){
  ret+=everBanned.get(i);
  if (i<everBanned.size()-1&&everBanned.size()>0) ret+=" ";
}
return ret;
}


}