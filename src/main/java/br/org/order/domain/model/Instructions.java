package br.org.order.domain.model;

public class Instructions {

    private String instructionPayer;
    private String instruction1;
    private String instruction2;
    private String instruction3;
    private String instruction4;
    private String instruction5;
    private String instruction6;
    private String instruction7;
    private String instruction8;

    private Instructions(Builder builder) {
        this.instructionPayer = builder.instructionPayer;
        this.instruction1 = builder.instruction1;
        this.instruction2 = builder.instruction2;
        this.instruction3 = builder.instruction3;
        this.instruction4 = builder.instruction4;
        this.instruction5 = builder.instruction5;
        this.instruction6 = builder.instruction6;
        this.instruction7 = builder.instruction7;
        this.instruction8 = builder.instruction8;
    }

    public String getInstructionPayer() {
        return instructionPayer;
    }

    public String getInstruction1() {
        return instruction1;
    }

    public String getInstruction2() {
        return instruction2;
    }

    public String getInstruction3() {
        return instruction3;
    }

    public String getInstruction4() {
        return instruction4;
    }

    public String getInstruction5() {
        return instruction5;
    }

    public String getInstruction6() {
        return instruction6;
    }

    public String getInstruction7() {
        return instruction7;
    }

    public String getInstruction8() {
        return instruction8;
    }

    @Override
    public String toString() {
        return String.format(
                "Instructions [instruction1=%s, instruction2=%s, instruction3=%s, instruction4=%s, instruction5=%s, instruction6=%s, instruction7=%s, instruction8=%s]",
                instruction1, instruction2, instruction3, instruction4, instruction5, instruction6, instruction7,
                instruction8);
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builderFrom(Instructions instructions) {
        return new Builder(instructions);
    }

    public static final class Builder {
        private String instructionPayer;
        private String instruction1;
        private String instruction2;
        private String instruction3;
        private String instruction4;
        private String instruction5;
        private String instruction6;
        private String instruction7;
        private String instruction8;

        private Builder() {
        }

        private Builder(Instructions instructions) {
            this.instructionPayer = instructions.instructionPayer;
            this.instruction1 = instructions.instruction1;
            this.instruction2 = instructions.instruction2;
            this.instruction3 = instructions.instruction3;
            this.instruction4 = instructions.instruction4;
            this.instruction5 = instructions.instruction5;
            this.instruction6 = instructions.instruction6;
            this.instruction7 = instructions.instruction7;
            this.instruction8 = instructions.instruction8;
        }

        public Builder withInstructionPayer(String instructionPayer) {
            this.instructionPayer = instructionPayer;
            return this;
        }

        public Builder withInstruction1(String instruction1) {
            this.instruction1 = instruction1;
            return this;
        }

        public Builder withInstruction2(String instruction2) {
            this.instruction2 = instruction2;
            return this;
        }

        public Builder withInstruction3(String instruction3) {
            this.instruction3 = instruction3;
            return this;
        }

        public Builder withInstruction4(String instruction4) {
            this.instruction4 = instruction4;
            return this;
        }

        public Builder withInstruction5(String instruction5) {
            this.instruction5 = instruction5;
            return this;
        }

        public Builder withInstruction6(String instruction6) {
            this.instruction6 = instruction6;
            return this;
        }

        public Builder withInstruction7(String instruction7) {
            this.instruction7 = instruction7;
            return this;
        }

        public Builder withInstruction8(String instruction8) {
            this.instruction8 = instruction8;
            return this;
        }

        public Instructions build() {
            return new Instructions(this);
        }
    }

}
