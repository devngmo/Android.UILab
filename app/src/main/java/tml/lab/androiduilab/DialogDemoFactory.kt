package tml.lab.androiduilab

import android.app.Activity
import android.widget.Toast
import com.afollestad.materialdialogs.MaterialDialog
import com.afollestad.materialdialogs.callbacks.onCancel
import com.afollestad.materialdialogs.callbacks.onDismiss
import com.afollestad.materialdialogs.callbacks.onPreShow
import com.afollestad.materialdialogs.callbacks.onShow
import com.afollestad.materialdialogs.checkbox.checkBoxPrompt
import com.afollestad.materialdialogs.checkbox.isCheckPromptChecked
import com.afollestad.materialdialogs.customview.customView
import com.afollestad.materialdialogs.list.listItems
import com.afollestad.materialdialogs.list.listItemsMultiChoice
import com.afollestad.materialdialogs.list.listItemsSingleChoice

class DialogDemoFactory {
    companion object {
        fun singleOption(a:Activity) {
            MaterialDialog(a).show {
                listItemsSingleChoice(R.array.dialog_options, initialSelection = 1) {
                        dialog, index, text ->
                    Toast.makeText(a, "Pick $index", Toast.LENGTH_SHORT).show()
                }
            }
        }
        fun singleOptionNeedConfirm(a:Activity) {
            val indices = intArrayOf(1, 3)
            MaterialDialog(a).show {
                listItemsSingleChoice(R.array.dialog_options,
                    initialSelection = 1,
                    waitForPositiveButton = true,
                    disabledIndices = indices
                ) {
                        dialog, index, text ->
                    Toast.makeText(a, "Pick $index", Toast.LENGTH_SHORT).show()
                }
                positiveButton ( text = "Confirm" ) {
                    //dialog -> Toast.makeText(a, "Pick ${dialog.item}", Toast.LENGTH_SHORT).show()
                }
            }


//            dialog.checkItem(index)
//
//            dialog.uncheckItem(index)
//
//            dialog.toggleItemChecked(index)
//
//            val checked: Boolean = dialog.isItemChecked(index)
        }
        fun multipleOptions(a: Activity) {
            MaterialDialog(a).show {
                listItemsMultiChoice(R.array.dialog_options) {
                        dialog, indices, text ->
                    Toast.makeText(a, "Pick ${indices.joinToString ( separator = ", " )}", Toast.LENGTH_SHORT).show()
                }
                positiveButton ( text = "Confirm" ) {
                    dialog ->
                }
            }
        }
        fun messageBox(a:Activity) {
            MaterialDialog(a).show {
                icon(R.drawable.ic_menu_gallery)
                title(text = "Welcome")
                message(text = "to Material Dialog") {
                    html() // format, color, etc. with tags in string
                    html { link ->  // same as above, but...
                        // Invokes a callback when a URL is clicked instead of auto opening it in a browser
                    }
                    lineSpacing(1.4f) // modifies line spacing, default is 1.0f

                    // You can directly act on the message TextView as well
                    //val textView = messageTextView
                }
                onPreShow {
                    Toast.makeText(a, "Before show", Toast.LENGTH_SHORT).show()
                }
                onShow {
                    Toast.makeText(a, "On Show", Toast.LENGTH_SHORT).show()
                }
                onDismiss {
                    Toast.makeText(a, "Dismissed", Toast.LENGTH_SHORT).show()
                }
                onCancel {
                    Toast.makeText(a, "Canceled", Toast.LENGTH_SHORT).show()
                }
            }
        }
        fun messageBoxYesNo(a:Activity) {
            MaterialDialog(a).show {
                title(text = "Welcome")
                message(text = "to Material Dialog")
                positiveButton(text = "OK") { dialog -> Toast.makeText(a, "Press OK", Toast.LENGTH_SHORT).show()}
                negativeButton(text = "Cancel") { dialog -> Toast.makeText(a, "Press Cancel", Toast.LENGTH_SHORT).show()}
            }
        }
        fun messageBoxYesNoApply(a:Activity) {
            MaterialDialog(a).show {
                title(text = "Welcome")
                message(text = "to Material Dialog")
                positiveButton(text = "OK") { dialog -> Toast.makeText(a, "Press OK", Toast.LENGTH_SHORT).show()}
                negativeButton(text = "Cancel")
                positiveButton()
            }
        }

        fun listSingleSelection(a: Activity) {
            MaterialDialog(a).show {
                listItems(R.array.dialog_options) {
                        dialog, index, text ->
                    Toast.makeText(a, "Pick $index", Toast.LENGTH_SHORT).show()
                }
            }
        }

        fun checkboxPrompt(a: Activity) {
            MaterialDialog(a).show {
                checkBoxPrompt(text = "Hello, World")
                { checked -> }
                positiveButton(text = "Confirm") { dialog ->
                    val isChecked = dialog.isCheckPromptChecked()
                    // do something
                }
            }
        }

        fun wifiConnect(a: Activity) {
            MaterialDialog(a).show {
                customView(R.layout.wifi_connect,
                    scrollable = false
                )
                negativeButton ( text = "Cancel" )
                positiveButton ( text = "OK" )
                noAutoDismiss()
                cornerRadius(32f)
            }
        }

    }
}