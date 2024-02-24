package com.dev.virtualstorebackend.service;

import com.dev.virtualstorebackend.entity.Imagem;
import com.dev.virtualstorebackend.entity.Produto;
import com.dev.virtualstorebackend.repository.ImagemRepository;
import com.dev.virtualstorebackend.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.List;

@Service
public class ImagemService {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private ImagemRepository imagemRepository;

    public List<Imagem> findAll() {
        return imagemRepository.findAll();
    }

    public Imagem create(Long idProduto, MultipartFile file) {
        Produto produto = produtoRepository.findById(idProduto).get();
        Imagem object = new Imagem();

        try {
            if (!file.isEmpty()) {
                byte[] bytes = file.getBytes();
                String nomeImagem = String.valueOf(produto.getId()) + file.getOriginalFilename();
                Path caminho = Paths
                        .get("c:/imagens/" + nomeImagem);
                Files.write(caminho, bytes);

                object.setNome(nomeImagem);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        object.setProduto(produto);
        object.setDataCriacao(new Date());
        object = imagemRepository.saveAndFlush(object);
        return object;
    }

    public Imagem edit(Imagem object) {
        object.setDataAtualizacao(new Date());
        return imagemRepository.saveAndFlush(object);
    }

    public Imagem delete(Long id) {
        Imagem object = imagemRepository.findById(id).get();
        imagemRepository.delete(object);
        return object;
    }
}
