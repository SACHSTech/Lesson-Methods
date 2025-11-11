public class Program7 extends ConsoleProgram {
    public void run() {
        // We want to draw a ladder with several repeating levels:
        //
        // |    |
        // +----+
        // |    |
        // +----+
        // |    |
        // +----+
        //
        // Ask the user how many levels high the ladder is. The above example is 3 levels high.

        int levels = readInt("How many levels? ");

        // call your methods here

    }

    // fill in the methods below

    private void side() {
        // draw the sides without rungs
    }

    private void rung() {
        // draw the horizontal rung or step
    }

    private void level() {
        // one level is made up of a side plus a rung
    }
}