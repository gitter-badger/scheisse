package org.dedda.games.scheisse.state.game.object.behavior;

import javax.script.ScriptException;

/**
 * Created by dedda on 10/4/14.
 */
public class NPCJumpIfEqual extends NPCScriptAction {

    private String expected;
    private String actual;
    private int jumpPoint;

    public NPCJumpIfEqual(final NPCScript skript) {
        super(skript);
    }

    @Override
    public boolean hasNextStep() {
        return true;
    }

    @Override
    public void nextStep() {
        double expected = 0;
        double actual = 0;
        try {
            expected = evalDouble(this.expected);
            actual = evalDouble(this.actual);
        } catch (ScriptException e) {
            e.printStackTrace();
        }
        if (expected == actual) {
            script.jump(jumpPoint);
        }
    }

    public String getExpected() {
        return expected;
    }

    public void setExpected(final String expected) {
        this.expected = expected;
    }

    public String getActual() {
        return actual;
    }

    public void setActual(final String actual) {
        this.actual = actual;
    }

    public int getJumpPoint() {
        return jumpPoint;
    }

    public void setJumpPoint(final int jumpPoint) {
        this.jumpPoint = jumpPoint;
    }

    @Override
    public boolean equals(final Object object) {
        if (!object.getClass().equals(this.getClass())) {
            return false;
        }
        NPCJumpIfEqual npcJumpIfEqual = (NPCJumpIfEqual)object;
        if (!npcJumpIfEqual.getActual().equals(actual) ||
                !npcJumpIfEqual.getExpected().equals(expected)) {
            return false;
        }
        if (npcJumpIfEqual.getJumpPoint() != jumpPoint) {
            return false;
        }
        return true;
    }
}
