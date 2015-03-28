package org.dedda.games.scheisse.state.game.object.behavior;

import javax.script.ScriptException;

/**
 * Created by dedda on 10/4/14.
 */
public class NPCJumpIfEqual extends NPCScriptAction {

    /**
     * expected value for jump.
     */
    private String expected;
    /**
     * actual value to compare.
     */
    private String actual;
    /**
     * point to jump to in the script.
     */
    private int jumpPoint;

    /**
     *
     * @param script
     */
    public NPCJumpIfEqual(final NPCScript script) {
        super(script);
    }

    /**
     * this method always returns true. after jump the cursor in the script
     * is at a different position so this action can't be run twice.
     *
     * @see NPCScriptAction#hasNextStep()
     *
     * @return always true
     */
    @Override
    public final boolean hasNextStep() {
        return true;
    }

    /**
     * evaluates expected and actual values and jumps or continues.
     *
     * @see NPCScriptAction#nextStep()
     */
    @Override
    public final void nextStep() {
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

    /**
     *
     * @return
     */
    public final String getExpected() {
        return expected;
    }

    /**
     *
     * @param expected
     */
    public final void setExpected(final String expected) {
        this.expected = expected;
    }

    /**
     *
     * @return
     */
    public final String getActual() {
        return actual;
    }

    /**
     *
     * @param actual
     */
    public final void setActual(final String actual) {
        this.actual = actual;
    }

    /**
     *
     * @return
     */
    public final int getJumpPoint() {
        return jumpPoint;
    }

    /**
     *
     * @param jumpPoint
     */
    public final void setJumpPoint(final int jumpPoint) {
        this.jumpPoint = jumpPoint;
    }

    /**
     *
     * objects are equal when expressions for expected and actual values
     * are equal and both objects have the same jump point.
     *
     * @param object
     * @return
     */
    @Override
    public final boolean equals(final Object object) {
        if (!object.getClass().equals(this.getClass())) {
            return false;
        }
        NPCJumpIfEqual npcJumpIfEqual = (NPCJumpIfEqual) object;
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
