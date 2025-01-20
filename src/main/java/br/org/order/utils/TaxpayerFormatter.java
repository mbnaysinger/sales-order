package br.org.order.utils;

public class TaxpayerFormatter {

    public static class FormattedTaxpayer {
        private final long id1;
        private final int id2;
        private final int id3;

        public FormattedTaxpayer(long id1, int id2, int id3) {
            this.id1 = id1;
            this.id2 = id2;
            this.id3 = id3;
        }

        public long getId1() { return id1; }
        public int getId2() { return id2; }
        public int getId3() { return id3; }
    }

    public static FormattedTaxpayer format(String taxpayerId) {
        if (taxpayerId == null || taxpayerId.isEmpty()) {
            throw new IllegalArgumentException("TaxpayerId é um campo obrigatório");
        }

        taxpayerId = taxpayerId.replaceAll("[^0-9]", "");
        boolean isCpf = taxpayerId.length() == 11;

        if (isCpf) {
            return formatCpf(taxpayerId);
        } else if (taxpayerId.length() == 14) {
            return formatCnpj(taxpayerId);
        } else {
            throw new IllegalArgumentException("Formato inválido. CPF deve conter 11 caracteres. CNPJ deve conter 15 caracteres.");
        }
    }

    private static FormattedTaxpayer formatCpf(String cpf) {
        long id1 = Long.parseLong(cpf.substring(1, 9));
        int id3 = Integer.parseInt(cpf.substring(9));
        return new FormattedTaxpayer(id1, 0, id3);
    }

    private static FormattedTaxpayer formatCnpj(String cnpj) {
        long id1 = Long.parseLong(cnpj.substring(0, 8));
        int id2 = Integer.parseInt(cnpj.substring(8, 12));
        int id3 = Integer.parseInt(cnpj.substring(12));
        return new FormattedTaxpayer(id1, id2, id3);
    }
}
