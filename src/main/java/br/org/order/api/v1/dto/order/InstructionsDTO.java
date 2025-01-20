package br.org.order.api.v1.dto.order;

public class InstructionsDTO {

    private String instructionPayer;

    private String instruction1;
    private String instruction2;
    private String instruction3;
    private String instruction4;
    private String instruction5;
    private String instruction6;
    private String instruction7;
    private String instruction8;

    public String getInstructionPayer() {
        return instructionPayer;
    }

    public void setInstructionPayer(String instructionPayer) {
        this.instructionPayer = instructionPayer;
    }

    public String getInstruction1() {
        return instruction1;
    }

    public void setInstruction1(String instruction1) {
        this.instruction1 = instruction1;
    }

    public String getInstruction2() {
        return instruction2;
    }

    public void setInstruction2(String instruction2) {
        this.instruction2 = instruction2;
    }

    public String getInstruction3() {
        return instruction3;
    }

    public void setInstruction3(String instruction3) {
        this.instruction3 = instruction3;
    }

    public String getInstruction4() {
        return instruction4;
    }

    public void setInstruction4(String instruction4) {
        this.instruction4 = instruction4;
    }

    public String getInstruction5() {
        return instruction5;
    }

    public void setInstruction5(String instruction5) {
        this.instruction5 = instruction5;
    }

    public String getInstruction6() {
        return instruction6;
    }

    public void setInstruction6(String instruction6) {
        this.instruction6 = instruction6;
    }

    public String getInstruction7() {
        return instruction7;
    }

    public void setInstruction7(String instruction7) {
        this.instruction7 = instruction7;
    }

    public String getInstruction8() {
        return instruction8;
    }

    public void setInstruction8(String instruction8) {
        this.instruction8 = instruction8;
    }

    @Override
    public String toString() {
        return String.format(
                "InstructionsDTO [instructionPayer=%s, instruction1=%s, instruction2=%s, instruction3=%s, instruction4=%s, instruction5=%s, instruction6=%s, instruction7=%s, instruction8=%s]",
                instructionPayer, instruction1, instruction2, instruction3, instruction4, instruction5, instruction6,
                instruction7, instruction8);
    }

}