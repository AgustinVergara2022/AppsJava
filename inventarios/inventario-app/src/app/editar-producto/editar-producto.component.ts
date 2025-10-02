import { Component } from '@angular/core';
import { Producto } from '../producto';
import { ProductoService } from '../producto.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-editar-producto',
  standalone: false,
  
  templateUrl: './editar-producto.component.html',
})
export class EditarProductoComponent {
  producto: Producto = new Producto();
  id: number;

  constructor(private productoServicio: ProductoService,
    private ruta: ActivatedRoute, private enrutador: Router){}

    ngOnInit() {
      this.id = this.ruta.snapshot.params['id'];
      console.log('ID capturado desde la URL:', this.id); // Verifica el ID
    
      this.productoServicio.obtenerProductoPorId(this.id).subscribe({
        next: (datos) => {
          console.log('Producto recibido del backend:', datos); // Verifica los datos del backend
          this.producto = datos; // Asigna los datos al modelo
        },
        error: (errores: any) => console.log('Error al obtener el producto:', errores),
      });
    }

  onSubmit(){
    this.guardarProducto();
  }

  guardarProducto(){
    this.productoServicio.guardarProducto(this.id, this.producto).subscribe(
      {
        next: (datos) => this.irProductoLista(),
        error: (errores) => console.log(errores)
      }
    );
  }

  irProductoLista(){
    this.enrutador.navigate(['/productos']);
  }
}
