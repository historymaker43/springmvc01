/**
 * myscript.js
 */

function isImage(filename){
			// 확장자 체크   - png, jpg, gif
			var dotIndex = filename.lastIndexOf(".");
			var extName = filename.substring(dotIndex + 1);
			var ext = extName.toLowerCase();
			if (ext == "png" || ext == "jpg" || ext == "gif"){
				return true;
			} else {
				return false;
			}
		}
		
		function getFilename(path) {
			var underIndex = path.indexOf("_");
			return path.substring(underIndex + 1);
		}