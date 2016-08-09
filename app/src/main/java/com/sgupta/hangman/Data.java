package com.sgupta.hangman;
public class Data {
    private String[] mHint={"If you look at the number on my face you won't find thirteen anyplace",
            "Tear one off and scratch my head what was red is black instead",
            "What do you call an Amish guy with his hand in a horse’s mouth?",
            "I travel all over the world, but always stay in my corner.",
            "With pointed fangs I sit and wait; with piercing force I crunch out fate; grabbing victims, proclaiming might; physically joining with a single bite. What am I?",
            "What do you break before you use it?",
            "Who makes it, has no need of it. Who buys it, has no use for it. Who uses it can neither see nor feel it.",
            "What gets wetter and wetter the more it dries?",
            "What kind of room has no doors or windows?",
            "What kind of tree can you carry in your hand?",
            "What is it that's always coming but never arrives?",
            "There was a green house. Inside the green house there was a white house. Inside the white house there was a red house. Inside the red house there were lots of babies.",
            "If you have me, you want to share me. If you share me, you haven't got me.",
            "Feed me and I live, yet give me a drink and I die.",
            "Forward I am heavy, but backward I am not.",
            "He has married many women, but has never been married.",
            "Light as a feather, but even the world's strongest man couldn't hold me for more than a minute",
            "I have one eye but still am blind.",
            "You pick it, You peel the outside, You cook the inside, You eat the outside, And throw away the inside.",
            "Pronounced as one letter, And written with three, Two letters there are, And two only in me. I'm double, I'm single, I'm black, blue, and gray, I'm read from both ends, And the same either way.",
            "They have not flesh, nor feathers, nor scales, nor bone. Yet they have fingers and thumbs of their own."};

    private String mAnswer[]= {"clock",
            "matchstick",
            "mechanic",
            "stamp",
            "stapler",
            "egg",
            "coffin",
            "towel",
            "mushroom",
            "palm",
            "tomorrow",
            "watermelon",
            "secret",
            "fire",
            "ton",
            "preacher",
            "breath",
            "needle",
            "corn",
            "eye",
            "gloves"};

    public String getAnswer(int i) {
        return mAnswer[i];
    }

    public String getHint(int i) {
        return mHint[i];
    }

    public int getLength(){
        return mAnswer.length;
    }
}
