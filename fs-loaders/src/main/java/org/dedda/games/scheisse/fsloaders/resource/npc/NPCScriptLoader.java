package org.dedda.games.scheisse.fsloaders.resource.npc;

import org.dedda.games.scheisse.fsloaders.resource.FileInput;
import org.dedda.games.scheisse.npc.behavior.NPCJumpIfEqual;
import org.dedda.games.scheisse.npc.behavior.NPCJumpIfTrue;
import org.dedda.games.scheisse.npc.behavior.NPCScript;
import org.dedda.games.scheisse.npc.behavior.NPCScriptAction;
import org.dedda.games.scheisse.npc.behavior.NPCWalk;
import org.dedda.games.scheisse.npc.behavior.NPCWalkToDestination;
import org.dedda.games.scheisse.npc.npc.NPC;
import org.dedda.games.scheisse.tool.Parse;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Class for loading {@link NPCScript}s from files for giving
 * {@link NPC}s a specific rule on how to behave.
 * <p/>
 * Created by dedda on 10/4/14.
 *
 * @author dedda
 */
public class NPCScriptLoader extends FileInput {

    /**
     * {@link NPCScript} that is be loaded by this instance.
     */
    private NPCScript npcScript = null;

    /**
     * {@link HashMap} for storing all possible jump points with names.
     */
    private HashMap<String, Integer> jumpPoints;

    /**
     * @param file {@link File} to load from
     * @param npc  {@link NPC} to connect the script with
     * @return Loaded {@link NPCScript}
     */
    public NPCScript loadNPCScript(final File file, final NPC npc) {
        npcScript = new NPCScript(npc);
        String[] lines = getLines(file);
        ArrayList<NPCScriptAction> npcScriptAction =
            new ArrayList<NPCScriptAction>();
        jumpPoints = new HashMap<String, Integer>();
        for (int i = 0; i < lines.length; i++) {
            if (!lines[i].contains(" ") && lines[i].endsWith(":")) {
                parseJumpPoint(lines[i], npcScriptAction.size());
                continue;
            }
            npcScriptAction.add(parseAction(lines[i]));
        }
        NPCScriptAction[] npcScriptActionArray
            = new NPCScriptAction[npcScriptAction.size()];
        for (int i = 0; i < npcScriptActionArray.length; i++) {
            npcScriptActionArray[i] = npcScriptAction.get(i);
        }
        npcScript.setAction(npcScriptActionArray);
        return npcScript;
    }

    /**
     * Parsing a single {@link NPCScriptAction} from one line of the script.
     *
     * @param line Line to parse to {@link NPCScriptAction}
     * @return Parsed {@link NPCScriptAction}
     */
    public NPCScriptAction parseAction(final String line) {
        String[] words = line.split(" ");
        if (words[0].equals("walk")) {
            return getNPCWalk(words);
        } else if (words[0].equals("walkTo")) {
            return getNPCWaltToDestination(words);
        } else if (words[0].equals("jumpIfEqual")) {
            return getNpcJumpIfEqual(words);
        } else if (words[0].equals("jumpIf")) {
            return getNpcJumpIfTrue(words);
        }
        return null;
    }

    /**
     * Parses the words from one line of script to
     * a {@link NPCJumpIfTrue} action.
     *
     * @param words Array of words from the code line
     * @return Parsed {@link NPCJumpIfTrue} action
     */
    private NPCJumpIfTrue getNpcJumpIfTrue(final String[] words) {
        NPCJumpIfTrue npcJumpIfTrue = new NPCJumpIfTrue(npcScript);
        npcJumpIfTrue.setExpression(words[1]);
        npcJumpIfTrue.setJumpPoint(jumpPoints.get(words[2]));
        return npcJumpIfTrue;
    }

    /**
     * Registers a new jump point to the {@link HashMap} of jump points
     *
     * @param line  Line with the name of the jump point
     * @param index Location of this jump point
     */
    private void parseJumpPoint(final String line, final int index) {
        jumpPoints.put(line.substring(0, line.length() - 1), index);
    }

    /**
     * Parses the words from one line of script to
     * a {@link NPCWalk} action.
     *
     * @param words Array of words from the code line
     * @return Parsed {@link NPCWalk} action
     */
    private NPCWalk getNPCWalk(final String[] words) {
        NPCWalk npcWalk = new NPCWalk(npcScript);
        npcWalk.setAmount(Parse.toDouble(words[1]));
        npcWalk.setDirection(Parse.toDouble(words[2]));
        return npcWalk;
    }

    /**
     * Parses the words from one line of script to
     * a {@link NPCWalkToDestination} action.
     *
     * @param words Array of words from the code line
     * @return Parsed {@link NPCWalkToDestination} action
     */
    private NPCWalkToDestination getNPCWaltToDestination(final String[] words) {
        NPCWalkToDestination npcWalkToDestination
            = new NPCWalkToDestination(npcScript);
        npcWalkToDestination.setDestination(Parse.toPoint2DDouble(words[1]));
        return npcWalkToDestination;
    }

    /**
     * Parses the words from one line of script to
     * a {@link NPCJumpIfEqual} action.
     *
     * @param words Array of words from the code line
     * @return Parsed {@link NPCJumpIfEqual} action
     */
    private NPCJumpIfEqual getNpcJumpIfEqual(final String[] words) {
        NPCJumpIfEqual npcJumpIfEqual = new NPCJumpIfEqual(npcScript);
        npcJumpIfEqual.setExpected(words[1]);
        npcJumpIfEqual.setActual(words[2]);
        npcJumpIfEqual.setJumpPoint(Parse.toInteger(words[3]));
        return npcJumpIfEqual;
    }

}
