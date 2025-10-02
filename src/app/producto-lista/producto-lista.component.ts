import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { Producto } from '../producto';
import { ProductoService } from '../producto.service';
import { Router } from '@angular/router';

@Component({
  standalone: true,
  selector: 'app-producto-lista',
  templateUrl: './producto-lista.component.html',
  imports: [CommonModule]
})
export class ProductoListaComponent {
  productos: Producto[] = []; // Inicializa para evitar errores de undefined

  constructor(private productoServicio: ProductoService, private enrutador: Router) {}

  ngOnInit() {
    this.obtenerProductos();
  }

  private obtenerProductos() {
    //consumir los datos del observable
    this.productoServicio.obtenerProductosLista().subscribe((datos) => {
      this.productos = datos;
    });
  }

  editarProducto(id: number){
    this.enrutador.navigate(['editar-producto', id]);
  }

  eliminarProducto(id: number){
    this.productoServicio.eliminarProducto(id).subscribe(
      {
        next: (datos) => this.obtenerProductos(),
        error: (errores) => console.log(errores)
      }
    );
  }
}
