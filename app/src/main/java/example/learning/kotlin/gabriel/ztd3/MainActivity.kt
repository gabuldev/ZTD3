package example.learning.kotlin.gabriel.ztd3

import android.support.design.widget.TabLayout
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.support.v4.view.ViewPager
import android.os.Bundle
import android.support.design.widget.TabItem
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Toast

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_main.view.*

class MainActivity : AppCompatActivity() {

    /**
     * The [android.support.v4.view.PagerAdapter] that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * [android.support.v4.app.FragmentStatePagerAdapter].
     */
    private var mSectionsPagerAdapter: SectionsPagerAdapter? = null

    //VARIAVEIS PARA CRIACAO DO CARD

    var mRecyclerView : RecyclerView? = null
    var listcardview : ArrayList<String>? = ArrayList<String>()

    //CRIANDO O ADAPTER PARA GERAR OS CARDS
    var mAdapter : MyAdapterCardView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //CARREGANDO A LISTA DE CARDS
        listcardview?.add("KitKat")
        listcardview?.add("Jelly Bean")
        listcardview?.add("Ice Cream Sandwich")
        listcardview?.add("Hoeycomb")
        listcardview?.add("Gingerbread")
        listcardview?.add("Froyo")
        listcardview?.add("Eclair")
        listcardview?.add("Donut")
        //CRIANDO O RECYCLER VIEW E MANDANDO PARA O ADAPTER
        mRecyclerView = findViewById<View>(R.id.recyclerView) as RecyclerView
        mRecyclerView?.setHasFixedSize(true)
        mRecyclerView?.layoutManager = LinearLayoutManager(this@MainActivity)

        mAdapter = MyAdapterCardView(this@MainActivity,listcardview)
        mRecyclerView?.adapter = mAdapter


        setSupportActionBar(toolbar)
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = SectionsPagerAdapter(supportFragmentManager)

        // Set up the ViewPager with the sections adapter.
        container.adapter = mSectionsPagerAdapter

        container.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tabs))
        tabs.addOnTabSelectedListener(TabLayout.ViewPagerOnTabSelectedListener(container))

        //TAB MENU TRANSICION
        /*val menutab1 = findViewById<TabItem>(R.id.tabItem) as TabItem
        menutab1.setOnClickListener {
            //CRIANDO O RECYCLER VIEW E MANDANDO PARA O ADAPTER
            mRecyclerView = findViewById<View>(R.id.recyclerView) as RecyclerView
            mRecyclerView?.setHasFixedSize(true)
            mRecyclerView?.layoutManager = LinearLayoutManager(this@MainActivity)

            mAdapter = MyAdapterCardView(this@MainActivity,listcardview)
            mRecyclerView?.adapter = mAdapter
        }

        val menutab2 = findViewById<TabItem>(R.id.tabItem2) as TabItem
        menutab2.setOnClickListener {
            val text = Toast.makeText(this,"PAG2 2 ",Toast.LENGTH_SHORT)
            text.show()
        }

        val menutab3 = findViewById<TabItem>(R.id.tabItem3) as TabItem
        menutab3.setOnClickListener {
            val text = Toast.makeText(this,"PAG2 3",Toast.LENGTH_SHORT)
            text.show()
        }*/


        //FAB
        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }

    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        val id = item.itemId

        if (id == R.id.action_settings) {
            return true
        }

        return super.onOptionsItemSelected(item)
    }


    /**
     * A [FragmentPagerAdapter] that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    inner class SectionsPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

        override fun getItem(position: Int): Fragment {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            return PlaceholderFragment.newInstance(position + 1)
        }

        override fun getCount(): Int {
            // Show 3 total pages.
            return 3
        }
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    class PlaceholderFragment : Fragment() {

        override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                                  savedInstanceState: Bundle?): View? {
            val rootView = inflater.inflate(R.layout.fragment_main, container, false)
            rootView.section_label.text = getString(R.string.section_format, arguments.getInt(ARG_SECTION_NUMBER))
            return rootView
        }

        companion object {
            /**
             * The fragment argument representing the section number for this
             * fragment.
             */
            private val ARG_SECTION_NUMBER = "section_number"

            /**
             * Returns a new instance of this fragment for the given section
             * number.
             */
            fun newInstance(sectionNumber: Int): PlaceholderFragment {
                val fragment = PlaceholderFragment()
                val args = Bundle()
                args.putInt(ARG_SECTION_NUMBER, sectionNumber)
                fragment.arguments = args
                return fragment
            }
        }
    }
}
