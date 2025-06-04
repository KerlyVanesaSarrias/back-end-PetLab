package com.petlab.petlab.dto;

import java.util.List;

public class PedidoRequest {
    private Long userId;
    private List<PedidoItem> items;

    public PedidoRequest() {
    }
    public PedidoRequest(Long userId, List<PedidoItem> items) {
        this.userId = userId;
        this.items = items;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public List<PedidoItem> getItems() {
        return items;
    }

    public void setItems(List<PedidoItem> items) {
        this.items = items;
    }
}
