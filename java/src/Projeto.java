class Projeto { 
    private String nomeProj; 
    private String descricao; 

    public Projeto(String nomeProj, String descricao) { 
        this.nomeProj = nomeProj;
        this.descricao = descricao;
    }

    public String getNomeProj() { 
        return nomeProj; 
    }

    public void setNomeProj(String nomeProj) { 
        this.nomeProj = nomeProj; 
    }

    public String getDescricao() { 
        return descricao; 
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
