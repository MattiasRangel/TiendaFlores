# Rosa Eterna: sistema de gestión para florería (Java Swing)

Aplicación de escritorio en Java para administrar una florería: clientes, inventario, ventas, facturación y entregas, con acceso por roles. Proyecto académico de Ingeniería de Sistemas (Universidad de Pamplona).

## Funcionalidades

- **Inicio de sesión por roles:** Florista (administración) y Cajero, cada uno con su propio menú.
- **Inventario:** registro de productos y actualización automática del stock tras cada venta.
- **Clientes:** registro y búsqueda de clientes, incluidos los clientes frecuentes con descuento.
- **Ventas y facturación:** carrito de compra, generación de factura y resumen de ventas.
- **Entregas:** seguimiento de los pedidos pendientes de entregar.

## Arquitectura

El proyecto sigue el patrón **MVC** y aplica **Programación Orientada a Objetos**:

```
src/
├── Modelo/        Clases de dominio
│   ├── Persona → Usuario → Florista, Cajero      (herencia)
│   ├── Persona → Cliente → ClienteFrecuente      (interfaz Frecuente y polimorfismo en el descuento)
│   ├── Producto (abstracta) → Rosa
│   ├── Venta, DetalleVenta, VentaResumen
│   └── TiendaRosas                               (almacén central de datos)
├── Controlador/   Controlador entre vistas y modelo
├── Vista/         Pantallas Swing (formularios de NetBeans)
└── rosaeterna/    Clase principal RosaEterna (main)
```

### Pantallas

| Flujo | Vistas |
|---|---|
| Acceso | `VistaBienvenida`, `VistaLogin` |
| Florista | `VistaMenuFlorista`, `VistaNuevoProducto`, `VistaBuscarClienteFlorista`, `VistaInventario`, `VistaVentasDelDiaFlorista` |
| Cajero | `VistaMenuCajero`, `VistaRegistrarCliente`, `VistaBuscarClienteCajero`, `VistaNuevaVenta`, `VistaFactura`, `VistaVentasDelDiaCajero` |

## Tecnologías

Java · Java Swing · NetBeans (Ant) · POO · MVC

## Cómo ejecutarlo

1. Abre el proyecto en **NetBeans** (incluye `build.xml` y `nbproject/`).
2. Ejecuta la clase principal `rosaeterna.RosaEterna`.

**Usuarios de prueba**

| Rol | Usuario | Contraseña |
|---|---|---|
| Florista (administrador) | `admin` | `12345` |
| Cajero | `cajero1` | `1111` |

## Limitaciones y próximas mejoras

- Los datos se guardan en memoria (`ArrayList`) y se pierden al cerrar la aplicación. El siguiente paso es la persistencia con **MySQL o SQLite mediante JDBC**.
- `VistaNuevaVentaAnterior` y `VistaFacturaAnterior` son una versión previa del flujo de venta que ya no se usa; se pueden eliminar.

## Autor

Eduard Mattias Rangel Ramírez · [LinkedIn](https://www.linkedin.com/in/mattias-rangel-8abab0310) · [GitHub](https://github.com/MattiasRangel)
