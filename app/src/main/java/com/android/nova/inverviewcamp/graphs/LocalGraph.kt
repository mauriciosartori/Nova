package com.android.nova.inverviewcamp.graphs
/**
 *
 */
class LocalGraph {
    val listNodes: ArrayList<LocalGraphNode> = ArrayList()

    init {
        val nodeA = LocalGraphNode("A")
        val nodeB = LocalGraphNode("B")
        val nodeC = LocalGraphNode("C")
        val nodeD = LocalGraphNode("D")
        val nodeE = LocalGraphNode("E")

        nodeA.listConnectedNodes.add(nodeB)

        nodeB.listConnectedNodes.add(nodeA)
        nodeB.listConnectedNodes.add(nodeE)
        nodeB.listConnectedNodes.add(nodeC)

        nodeC.listConnectedNodes.add(nodeB)
        nodeC.listConnectedNodes.add(nodeE)

        nodeD.listConnectedNodes.add(nodeE)

        nodeE.listConnectedNodes.add(nodeD)
        nodeE.listConnectedNodes.add(nodeB)
        nodeE.listConnectedNodes.add(nodeC)


        listNodes.add(nodeA)
        listNodes.add(nodeB)
        listNodes.add(nodeC)
        listNodes.add(nodeD)
        listNodes.add(nodeE)
    }
}

class LocalGraphNode(val value: String) {
    var status = LocalGraphStatus.AVAILABLE
    val listConnectedNodes: ArrayList<LocalGraphNode> = ArrayList()

}
enum class LocalGraphStatus {
    AVAILABLE, STANDBY, DONE
}