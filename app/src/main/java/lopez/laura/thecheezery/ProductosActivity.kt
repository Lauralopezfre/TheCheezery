package lopez.laura.thecheezery

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.ListView
import android.widget.TextView

class ProductosActivity : AppCompatActivity() {

    var coldDrinks = ArrayList<Product>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_productos)

        agregaProductos()
        var listview: ListView = findViewById(R.id.listview) as ListView
        var adaptador: AdaptadorProductos = AdaptadorProductos(this, coldDrinks)
        listview.adapter = adaptador
    }

    fun agregaProductos(){
        coldDrinks.add(Product("Caramel Frap", R.drawable.caramelfrap, "Caramel syrup meets coffee, milk and ice and whipped cream and buttery caramel sauce layer the love on top.", 5.0))
        coldDrinks.add(Product("Chocolate Frap", R.drawable.chocolatefrap, "Rich mocha-flavored sauce meets up with chocolaty chips, milk and ice for a blender bash.", 6.0))
        coldDrinks.add(Product("Cold Brew", R.drawable.coldbrew, "Created by steeping medium-to-coarse ground coffee in room temperature water for 12 hours or longer", 3.0))
        coldDrinks.add(Product("Matcha Latte", R.drawable.matcha, "Leafy taste of matcha green tea powder with creamy milk and a little sugar for a flavor balance that will leave you feeling ready and raring to go.", 4.0))
        coldDrinks.add(Product("Oreo Milkshake", R.drawable.oreomilkshake, "Chocolate ice cream, and oreo cookies. Topped with whipped cream with cocoa and chocolate syrup.", 7.0))
        coldDrinks.add(Product("Peanut Milkshake", R.drawable.peanutmilkshake, "Vanilla ice cream, mixed with peanut butter and chocolate.", 7.0))

    }

    private class AdaptadorProductos:BaseAdapter{
        var productos = ArrayList<Product>()
        var contexto: Context? = null
        constructor(context: Context, productos: ArrayList<Product>){
            this.productos = productos
            this.contexto = context
        }

        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            var prod = productos[position]
            var inflador = LayoutInflater.from(contexto)
            var vista = inflador.inflate(R.layout.producto_view, null)

            var ima = vista.findViewById(R.id.producto_img) as ImageView
            var nom = vista.findViewById(R.id.producto_nombre) as TextView
            var desc = vista.findViewById(R.id.producto_descripcion) as TextView
            var precio = vista.findViewById(R.id.producto_precio) as TextView

            ima.setImageResource(prod.image)
            nom.setText(prod.name)
            desc.setText(prod.description)
            precio.setText("$${prod.price}")

            return vista
        }

        override fun getItem(position: Int): Any {
            return productos[position]
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getCount(): Int {
            return productos.size
        }
    }
}