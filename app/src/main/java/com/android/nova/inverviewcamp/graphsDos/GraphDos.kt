package com.android.nova.inverviewcamp.graphsDos
/**
 *
 */
class GraphDos(val mainNode: NodeDos) {

}

class NodeDos(val value: String, var nodesLists: MutableList<NodeDos> = ArrayList(), var state: StateTwo = StateTwo.AVAILABLE )
enum class StateTwo {AVAILABLE, VISITING, VISITED}